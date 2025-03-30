package com.metacoding.storev2.log;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.metacoding.storev2.log.LogResponse.LogListItemDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class LogRepository {
    private final EntityManager em;

    public List<LogResponse.LogListItemDTO> findAllByUserIdJoinStoreJoinUser(int userId) {
        Query query = em.createNativeQuery(
                """
                        select lt.id, ut.fullname, st.name, lt.qty, lt.total_price 
                        from LOG_TB lt 
                            inner join store_tb st 
                                on lt.store_id = st.id 
                            inner join user_tb ut 
                                on lt.user_id = ut.id
                        where
                            lt.user_id = ?;
                            """);
        query.setParameter(1, userId);

        List<Object[]> objectsList = query.getResultList();

        List<LogResponse.LogListItemDTO> logListItemDTOList = new ArrayList<>();

        for (Object[] objects : objectsList) {
            logListItemDTOList.add(
                    new LogResponse.LogListItemDTO(
                            (int) objects[0],
                            (String) objects[1],
                            (String) objects[2],
                            (int) objects[3],
                            (int) objects[4]));
        }

        return logListItemDTOList;
    }

    public void save(int userId, int storeId, int qty, int totalPrice) {
        Query query = em.createNativeQuery("insert into log_tb (user_id, store_id, qty ,total_price, created_at) values (?,?,?,?, now())");
        query.setParameter(1, userId);
        query.setParameter(2, storeId);
        query.setParameter(3, qty);
        query.setParameter(4, totalPrice);
        query.executeUpdate();
    }
}
