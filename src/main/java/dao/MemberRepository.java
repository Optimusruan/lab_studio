package dao;


import org.springframework.data.repository.CrudRepository;
import model.Member;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface MemberRepository extends CrudRepository<Member,Long> {
    @Transactional
    Iterable<Member> findByMemberId(int id);
}
