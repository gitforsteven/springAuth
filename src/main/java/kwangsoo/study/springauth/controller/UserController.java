package kwangsoo.study.springauth.controller;

import jakarta.servlet.http.HttpServletResponse;
import kwangsoo.study.springauth.auth.AuthController;
import kwangsoo.study.springauth.dto.LoginRequestDto;
import kwangsoo.study.springauth.dto.SignupRequestDto;
import kwangsoo.study.springauth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user/signup")
    public String signup(SignupRequestDto request) {
        userService.signup(request);
        return "redirect:/api/user/login-page";
    }

    @PostMapping("/user/login")
    public String login(LoginRequestDto request, HttpServletResponse res) {
        try {
            userService.login(request, res);
        } catch (Exception e) {
            return "redirect:/api/user/login-page?error";
        }
        return "redirect:/";
    }

    @GetMapping("/user/login-page")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/user/signup")
    public String signupPage() {
        return "signup";
    }
}