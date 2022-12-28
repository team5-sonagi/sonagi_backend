package com.example.sonagi.addedQuestion.service;

import com.example.sonagi.addedQuestion.domain.AddedQuestion;
import com.example.sonagi.addedQuestion.domain.AddedQuestionRepository;
import com.example.sonagi.addedQuestion.dto.AddedQuestionDto;
import com.example.sonagi.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AddedQuestionService {
    private final AddedQuestionRepository addedQuestionRepository;

    @Transactional
    public Long save(AddedQuestionDto addedQuestionDto, User user) {
        AddedQuestion addedQuestion = AddedQuestion.from(addedQuestionDto, user);
        return addedQuestionRepository.save(addedQuestion).getId();
    }

    @Transactional
    public AddedQuestion findByFamilyId(Long familyId) {
        AddedQuestion addedQuestion = addedQuestionRepository.findByFamilyId(familyId).orElseThrow(() -> new IllegalArgumentException("해당 질문이 없습니다."));
        return addedQuestion;
    }

}
