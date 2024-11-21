package edu.gmu.swe645.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.gmu.swe645.demo.models.Survey;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
}
