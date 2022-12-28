package com.example.sonagi.addedQuestion.service;

import com.example.sonagi.addedQuestion.domain.AddedQuestion;
import com.example.sonagi.addedQuestion.domain.AddedQuestionRepository;
import com.example.sonagi.addedQuestion.dto.AddedQuestionRequest;
import com.example.sonagi.addedQuestion.dto.AddedQuestionResponse;
import com.example.sonagi.user.domain.User;
import com.example.sonagi.user.domain.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AddedQuestionService {
    private final AddedQuestionRepository addedQuestionRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long save(AddedQuestionRequest addedQuestionRequest, User user) {
        AddedQuestion addedQuestion = AddedQuestion.from(addedQuestionRequest, user);
        userRepository.save(user);
        return addedQuestionRepository.save(addedQuestion).getId();
    }

    public List<AddedQuestionResponse> findAllByFamilyId(Long familyId) {
        return AddedQuestionResponse.from(addedQuestionRepository.findAllByFamilyId(familyId));
    }
}
