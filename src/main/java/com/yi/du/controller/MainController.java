package com.yi.du.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Api(tags = "主页面")
public class MainController {

//    @Autowired
//    private ExamService examService;
//
//    @Autowired
//    private VideoService videoService;

//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }
//
//    @GetMapping("/test")
//    @ResponseBody
//    public String test(@ModelAttribute PageInfoBeen pageInfo) {
//        System.out.println("userAdd");
//        return "pageInfo: num_" + (pageInfo != null ? pageInfo.getPage_num() : null) + ", size_" + (pageInfo != null ? pageInfo.getPage_size() : null);
//    }


@GetMapping("/")
public String index() {
    return "index";
}


//    @GetMapping({"/video/list"})
//    public String list(HttpServletRequest request) {
//        return "/" + request.getRequestURI();
//    }
//
//    @GetMapping("/register")
//    @SystemControllerLog("注册页面")
//    public String register() {
//        return "/register";
//    }
//
//    @GetMapping({"/exam/upload"})
//    public String mainPage(HttpServletRequest request) {
//        return request.getRequestURI();
//    }
//
//    @PostMapping("/exam/main")
//    public String examMain(MultipartFile file, ModelMap modelMap) throws IOException {
//        if (file != null && !file.isEmpty()) {
//            InputStream in = file.getInputStream();
//            Word2ExamData util = new Word2ExamData(in);
//            String result = util.verifyWord();
//            ExamData data = util.parseWord();
//
//            examService.insert(data);
//        }
//
//        return "redirect:/exam/list";
//    }
//
//    @GetMapping("/exam/list")
//    public String examList(HttpServletRequest request, Model model) {
//        model.addAttribute("exams", examService.list());
//        return getPageURI(request, model);
//    }
//
//    @GetMapping("/exam/main/{id}")
//    public String examMain(@PathVariable Long id, HttpServletRequest request, Model model) {
//        model.addAttribute("exam", examService.selectById(id));
//        return getPageURI("/exam/main", request, model);
//    }
//
//    @GetMapping("/video/play/{id}")
//    public String vedioPlay(@PathVariable Long id, Model model) {
//        model.addAttribute("video", videoService.selectById(id));
//        return "/video/play";
//    }
//
//    private String getPageURI(String uri, HttpServletRequest request, Model model) {
//        uri = uri == null ? (request.getRequestURI() + "_include") : uri + "_include";
//
//        model.addAttribute("currentUser", request.getSession().getAttribute(UserManager.CURRENT_USER));
//        if (isPjax(request)) {
//            return uri;
//        } else {
//            model.addAttribute("includePage", uri + ".html");
//
////            List<Menu> menuList = null;
////
////            Subject subject = SecurityUtils.getSubject();
////            if (subject != null) {
////                if (subject.hasRole(RoleType.ADMIN)) {
////                    menuList = MenuDataManager.getMenu(MenuDataManager.economy_manager);
////                } else if (subject.hasRole(RoleType.EXPERT)) {
////                    menuList = MenuDataManager.getMenu(MenuDataManager.expert_guidance);
////                } else if (subject.hasRole(RoleType.CITY_RESEARCH)) {
////                    menuList = MenuDataManager.getMenu(MenuDataManager.city_office);
////                } else if (subject.hasRole(RoleType.AREA_RESEARCH)) {
////                    menuList = MenuDataManager.getMenu(MenuDataManager.area_office);
////                } else if (subject.hasRole(RoleType.SCHOOL_RESEARCH)) {
////                    menuList = MenuDataManager.getMenu(MenuDataManager.school_manager);
////                } else if (subject.hasRole(RoleType.SUBJECT_HOST)) {
////                    menuList = MenuDataManager.getMenu(MenuDataManager.subject_host);
////                }
////            }
////
////            model.addAttribute("menuList", menuList);
//
//            return "/home";
//        }
//    }
//
//    private String getPageURI(HttpServletRequest request, Model model) {
//        return getPageURI(null, request, model);
//    }
//
//    /**
//     * 判断pjax请求
//     *
//     * @param request
//     * @return
//     */
//    private boolean isPjax(HttpServletRequest request) {
//        return (request.getHeader("X-PJAX") != null
//                && "true".equals(request.getHeader("X-PJAX")));
//    }
}