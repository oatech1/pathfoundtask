package com.oatech.PathFoundTask.repository;

import com.oatech.PathFoundTask.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
