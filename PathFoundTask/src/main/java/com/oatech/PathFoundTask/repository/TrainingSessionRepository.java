package com.oatech.PathFoundTask.repository;

import com.oatech.PathFoundTask.entity.Coach;
import com.oatech.PathFoundTask.entity.TrainingSession;
import com.oatech.PathFoundTask.enums.Days;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface TrainingSessionRepository extends JpaRepository<TrainingSession,Long> {

    @Query(value = "SELECT * FROM training_session WHERE training_session.coach_id = :coachId", nativeQuery = true)
    List<TrainingSession> findTrainingSessionsByCoachId(@Param("coachId") Long coachId);

    @Query(value = "SELECT * FROM training_session t WHERE t.coach_id = :coachId AND t.member_id = :memberId  ", nativeQuery = true)
    List<TrainingSession> findSessionsByCoachIdAndMemberId(
            @Param("coachId") Long coachId,@Param("memberId") Long memberId);


    @Query(value = "SELECT * FROM training_session t WHERE t.coach_id = :coachId AND t.dofwk IN :weekdays  ", nativeQuery = true)
   List<TrainingSession> findByCoachIdAndDofwk( @Param("coachId") Long coachId, @Param("weekdays")Set<String> weekdays);
  //  List<TrainingSession> findByCoachIdAndDofwk( Long coachId, Set<Days> weekdays);
}
