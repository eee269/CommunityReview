package com.review.yj.community.controller.member;

import com.review.yj.community.dto.member.MemberSignUpRequestDto;
import com.review.yj.community.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/member")
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/signUp")
    public Long signUp(@RequestBody MemberSignUpRequestDto requestDto){
        return memberService.signUp(requestDto);
    }



    @PostMapping("/signIn/{mem_userid}")
    public String signIn(@PathVariable String mem_userid, HttpSession session) {
        // 로그인 세션 설정
        Long id = memberService.findByUserid(mem_userid);
        session.setAttribute("id", id);

        return "redirect:/";
    }


    @GetMapping("/mypage/{id}")
    public ModelAndView mypage(@PathVariable Long id ) throws Exception{
//                         Model model, @RequestBody MemberResponseDto responseDto) {
        // member 정보 넘기는것 보충하기
//        responseDto = memberService.findById(id);
//        model.addAttribute(responseDto);

        ModelAndView mav = new ModelAndView();
        mav.setViewName("member/my_page");
//        mav.addObject("responseDto", responseDto);
        return mav;
    }


}
