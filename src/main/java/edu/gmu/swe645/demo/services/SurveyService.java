package edu.gmu.swe645.demo.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.gmu.swe645.demo.models.Survey;
import edu.gmu.swe645.demo.repository.SurveyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    public Survey createSurvey(Survey survey) {
        return surveyRepository.save(survey);
    }

    public List<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }

    public Optional<Survey> getSurveyById(Long id) {
        return surveyRepository.findById(id);
    }

    public Survey updateSurvey(Long id, Survey updatedSurvey) {
        return surveyRepository.findById(id).map(survey -> {
            survey.setFirstName(updatedSurvey.getFirstName());
            survey.setLastName(updatedSurvey.getLastName());
            return surveyRepository.save(survey);
        }).orElseThrow(() -> new RuntimeException("Survey not found"));
    }

    public void deleteSurvey(Long id) {
        surveyRepository.deleteById(id);
    }
}
