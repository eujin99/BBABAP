package com.encore.bbabap.api.comment;

import com.encore.bbabap.api.comment.request.CommentRequestDTO;
import com.encore.bbabap.api.comment.response.CommentResponseDTO;
import com.encore.bbabap.service.Comment.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentResponseDTO> addComment(@RequestBody CommentRequestDTO requestDTO) {
        CommentResponseDTO createdComment = commentService.addComment(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdComment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }
}
