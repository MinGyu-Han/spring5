package controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import spring.DuplicateMemberException;
import spring.Member;
import spring.MemberDao;
import spring.MemberNotFoundException;
import spring.MemberRegisterService;
import spring.RegisterRequest;

@RestController
public class RestMemberController {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MemberRegisterService registerService;
	
	@GetMapping("/api/members")
	public List<Member> members() {
		return memberDao.selectAll();
	}
	
	@GetMapping("/api/members/{id}")
	public ResponseEntity<Object> member(@PathVariable Long id, HttpServletResponse response) throws IOException {
		Member member = memberDao.selectById(id);
		if(member == null) {
			//response.sendError(HttpServletResponse.SC_NOT_FOUND);
			//return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("no member"));
			throw new MemberNotFoundException();
		}
		return ResponseEntity.status(HttpStatus.OK).body(member);
	}
	
	@PostMapping("/api/members")
	public ResponseEntity<Object> newMember(
			@RequestBody @Valid RegisterRequest regReq, Errors errors){
		if (errors.hasErrors()) {
			String errorCodes = errors.getAllErrors()
					.stream()
					.map(error -> error.getCodes()[0])
					.collect(Collectors.joining(","));
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(new ErrorResponse("errorCode = " + errorCodes));			
		}
		try {
			Long newMemberId = registerService.regist(regReq);
			/*
			response.setHeader("Location", "/api/members/" + newMemberId);
			response.setStatus(HttpServletResponse.SC_CREATED);
			*/
			return ResponseEntity.status(HttpStatus.CREATED).body("/api/members/" + newMemberId);
		} catch (DuplicateMemberException dupEx) {
			//response.sendError(HttpServletResponse.SC_CONFLICT);
			return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse("중복 멤버"));
		}
	}

}
