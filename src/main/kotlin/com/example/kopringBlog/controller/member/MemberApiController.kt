package com.example.kopringBlog.controller.member

import com.example.kopringBlog.const.CommonConst
import com.example.kopringBlog.dto.member.MemberCreateRequest
import com.example.kopringBlog.dto.member.MemberLoginRequest
import com.example.kopringBlog.service.member.MemberService
import lombok.extern.slf4j.Slf4j
import org.json.JSONObject
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpSession

@RestController("/member")
@Slf4j
class MemberApiController(
    private val memberService: MemberService,
) {
    /**
     * 로그인
     */
    @GetMapping
    fun login(@ModelAttribute request: MemberLoginRequest, httpRequest : HttpServletRequest, jsonObject : JSONObject): JSONObject {
        val authUser = memberService.getMember(request.memberId)
        if(authUser != null){
            var session: HttpSession = httpRequest.session
            session.setAttribute(CommonConst.LOGIN_MEMBER, authUser)
            jsonObject.put("authUser", authUser)
        }
        return jsonObject
    }

    /**
     * ID 중복 체크
     */
    @GetMapping("/idCheck")
    fun idCheck(@RequestParam("memberId") memberId: String): Map<String, String>{
        val json : MutableMap<String, String> = mutableMapOf()
        memberService.getMember(memberId) ?: json.put("success", "true")
        return json
    }

    /**
     * 회원가입
     */
    @PostMapping
    fun join(@ModelAttribute request: MemberCreateRequest): Map<String, Boolean>{
        val json : MutableMap<String, Boolean> = mutableMapOf()
        try {
            memberService.createMember(request)
            json["success"] = true
        } catch(e: Exception){
            json["success"] = false
        }
        return json
    }

    /**
     * 회원정보 수정
     */
    @PutMapping
    fun update(){

    }

    /**
     * 회원 탈퇴
     */
    @DeleteMapping
    fun delete(){

    }
}