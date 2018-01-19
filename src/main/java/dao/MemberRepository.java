package dao;


import org.springframework.data.repository.CrudRepository;
import model.MemberEntity;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface MemberRepository extends CrudRepository<MemberEntity,Long> {
    @Transactional
    Iterable<MemberEntity> findByMemberId(int id);
}
