package com.example.modelanddatabase.dao;

import java.util.List;
import com.example.modelanddatabase.vo.MyData;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import javax.persistence.EntityManager;
import javax.persistence.Query;



@Repository
public class MyDataDaoImpl implements MyDataDao<MyData> {
    private static final long serialVersionUID = 1L;

    private EntityManager entityManager;

    public MyDataDaoImpl() {
        super();
    }

    public MyDataDaoImpl(EntityManager manager) {
        entityManager = manager;
    }

    @Override
    public List<MyData> getAll() {
        Query query = entityManager.createQuery("from MyData");
        List<MyData> list = query.getResultList();
        entityManager.close();
        return list;
    }

    @Override
    public MyData findById(long id) {
        return (MyData)entityManager.createQuery("from MyData where id = " + id).getSingleResult();
    }

    @Override
    public List<MyData> findByName(String name) {
        return (List<MyData>)entityManager.createQuery("from MyData where name = " + name).getResultList();
    }


//    @Query("from MyData where age > :min and age < :max")
//    public List<MyData> findByAge(@Param("min") int min, @Param("max") int max);

    @Override
//    public List<MyData> find(String fstr) {
//        List<MyData> list = null;
//        String qstr = "from MyData where id = :fstr";
//        Query query = entityManager.createQuery(qstr).setParameter("fstr", Long.parseLong(fstr));
//        list = query.getResultList();
//        return list;
//    }

    //JPQL 매개변수를 이용한 데이터 쿼리 진행
//    public List<MyData> find(String fstr) {
//        List<MyData> list = null;
//        String qstr = "from MyData where id = :fid or name like :fname or mail like :fmail";
//        Long fid = 0L;
//        try {
//            fid = Long.parseLong(fstr);
//        } catch (NumberFormatException e){
//            //e.printStackTrace();
//        }
//        Query query = entityManager.createQuery(qstr).setParameter("fid", fid)
//                .setParameter("fname", "%" + fstr + "%")
//                .setParameter("fmail", fstr + "@%");
//        list = query.getResultList();
//        return list;
//    }
    
    // ?를 이용한 번호 지정 매개변수
//    public List<MyData> find(String fstr) {
//        List<MyData> list = null;
//        String qstr = "from MyData where id = ?1 or name like ?2 or mail like ?3";
//        Long fid = 0L;
//        try {
//            fid = Long.parseLong(fstr);
//        } catch (NumberFormatException e) {
//            //e.printStackTrace();
//        }
//        Query query = entityManager.createQuery(qstr).setParameter(1, fid)
//                .setParameter(2, "%" + fstr + "%")
//                .setParameter(3, fstr + "@%");
//        list = query.getResultList();
//        return list;
//    }

    //MyData 클래스에서 지정한 @Namequeries를 이용한 데이터 질의
        public List<MyData> find(String fstr) {
        List<MyData> list = null;
        Long fid = 0L;
        try {
            fid = Long.parseLong(fstr);
        } catch (NumberFormatException e) {
            //e.printStackTrace();
        }
        Query query = entityManager.createNamedQuery("findWithName").setParameter("fname", "%" + fstr + "%");
        list = query.getResultList();
        return list;
    }

    // 나이 범위 내에 있는 모든 사람들 찾기
    @Override
    public List<MyData> findByAge(int min, int max) {
        return (List<MyData>)entityManager
                .createNamedQuery("findByAge")
                .setParameter("min", min)
                .setParameter("max", max)
                .getResultList();
    }



}
