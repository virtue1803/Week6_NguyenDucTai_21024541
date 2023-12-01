package dev.week6_nguyenductai_21024541.backend.controller;

import dev.week6_nguyenductai_21024541.backend.models.Post;
import dev.week6_nguyenductai_21024541.backend.models.User;
import dev.week6_nguyenductai_21024541.backend.services.PostService;
import dev.week6_nguyenductai_21024541.backend.services.Post_commentService;
import dev.week6_nguyenductai_21024541.backend.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;
    @Autowired
    private Post_commentService commentService;

    @GetMapping("/create-new-post")
    public String createNewPost(Model model, HttpServletRequest request) {
        User user = (User) request.getServletContext().getAttribute("accountLogin");

        if(user == null) {
            return "index";
        }

        model.addAttribute("listPostsNotParent", postService.findPostsByAuthorIdAndNotParentPost(user));
        return "post/post_add";
    }

    @PostMapping("/create-blog")
    public String createNewPost(
            @RequestParam String title,
            @RequestParam String meta,
            @RequestParam String summary,
            @RequestParam String content,
            @RequestParam String published,
            @RequestParam String parentId,
            HttpServletRequest request,
            Model model
    ) {
        User user = (User) request.getServletContext().getAttribute("accountLogin");
        if(user == null) {
            return "index";
        }

        Post parentPost = (parentId == null ? null : postService.findById(Long.parseLong(parentId)).get());
        Post post = new Post(user, parentPost, title, meta, summary, published.equalsIgnoreCase("Yes") ? true : false,
                LocalDateTime.now(), LocalDateTime.now(), published.equalsIgnoreCase("Yes") ? LocalDateTime.now() : null,
                content);

        model.addAttribute("postDetail", post);
        model.addAttribute("listPost", postService.findAllByPublishedIsTrue(true));

        postService.save(post);
        return "homepage";
    }

    @GetMapping("/view-detail/{postId}")
    public String viewDetail(@PathVariable("postId") String postId, Model model) {
        Post post = postService.findById(Long.parseLong(postId)).get();
        model.addAttribute("postDetail", post);
        model.addAttribute("listComments", commentService.findListCommentByPostId(post));
        return "post/post_detail";
    }
}
