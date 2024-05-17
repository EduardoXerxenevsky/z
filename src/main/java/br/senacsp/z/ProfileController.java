package br.senacsp.z;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
    private ProfileRepository profileRepository;

    @PostMapping("/register")
    public String register(@ModelAttribute Profile profile, Model model) {
        if (profileRepository.existsByEmail(profile.getEmail())) {
            model.addAttribute("errorMessage", "Email já registrado. Tente outro.");
            return "index"; // Redirecionar para a página inicial com mensagem de erro
        }
        profileRepository.save(profile);
        model.addAttribute("successMessage", "Registro realizado com sucesso!");
        return "index"; // Redirecionar para a página inicial com mensagem de sucesso
    }

    @PostMapping("/login")
    public String login(@ModelAttribute Profile profile, Model model, HttpSession session) {
        Profile existingProfile = profileRepository.findByEmail(profile.getEmail());
        if (existingProfile == null || !existingProfile.getPassword().equals(profile.getPassword())) {
            model.addAttribute("errorMessage", "Email ou senha inválidos. Tente novamente.");
            return "index"; // Redirecionar para a página inicial com mensagem de erro
        }
        session.setAttribute("loggedIn", true);
        session.setAttribute("profile", existingProfile);
        model.addAttribute("successMessage", "Login realizado com sucesso!");
        return "index"; // Redirecionar para a página inicial com mensagem de sucesso
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/"; // Redirecionar para a página inicial após logout
    }

    @GetMapping("/all")
    public String viewAllProfiles(Model model) {
        model.addAttribute("profiles", profileRepository.findAll());
        return "profile/list"; // Redirecionar para a página de listagem de perfis
    }
}
