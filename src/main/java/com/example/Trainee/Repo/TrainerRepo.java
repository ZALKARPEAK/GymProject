package com.example.Trainee.Repo;

import com.example.Trainee.entity.Trainer;
import com.example.Trainee.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrainerRepo extends JpaRepository<Trainer, Long> {
    @Query("SELECT t FROM Trainer t JOIN FETCH t.user u WHERE u.username = :username")
    Trainer findTrainerByUser_Username(@Param("username") String username);

    @Query("SELECT t FROM Trainer t WHERE t.user.isActive = true")
    List<Trainer> findActiveTrainer();

    @Query("SELECT t FROM Trainer t JOIN t.user u WHERE u.username in :usernames")
    List<Trainer> findTraineeByUser_Username2(@Param("usernames") List<String> usernames);

    @Query("select t from Training t join t.trainer.user u where u.username in :usernames")
    List<Training> findByTraining_UserNameIn(@Param("usernames") List<String> usernames);

}