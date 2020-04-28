package com.mongodb.demo.dao.impl;

import com.mongodb.demo.dao.UserDao;
import com.mongodb.demo.entity.UserEntity;
import com.mongodb.demo.entity.UserEntityDO;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 所要操作集合名
     */
    private static final String COLLECTION_NAME = "user";

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);


    /**
     * 插入数据
     * @param user
     */
    @Override
    public void saveUser(UserEntity user) {
        mongoTemplate.save(user,COLLECTION_NAME);
    }

    /**
     * 根据
     * @param id
     * @return
     */
    @Override
    public UserEntity findOneById(Long id) {
        Query query = new Query(Criteria.where("id").is(id));
        UserEntity user = mongoTemplate.findOne(query, UserEntity.class,COLLECTION_NAME);
        return user;
    }

    /**
     * 分页查询 简单分页 如果有需要可以抽象分页 使用PageResult暂不演示
     * @param userEntityDO
     * @return
     */
    @Override
    public List<UserEntity> findUserByPage(UserEntityDO userEntityDO) {
        List<UserEntity> userEntityList = null;
        try {
            List<AggregationOperation> operations = new ArrayList<>();
            if(null != userEntityDO.getPassWord()){
                Criteria criteria = Criteria.where("passWord").is(userEntityDO.getPassWord());
                operations.add(Aggregation.match(criteria));
            }
            if(null != userEntityDO.getUserName()){
                Criteria criteria = Criteria.where("userName").regex(userEntityDO.getUserName());
                operations.add(Aggregation.match(criteria));
            }
            //使用skip 跳过数据，如果数据量庞大则影响性能问题
            operations.add(Aggregation.skip((long) (userEntityDO.getCurrentPage() - 1) * userEntityDO.getPageSize()));
            operations.add(Aggregation.limit(userEntityDO.getPageSize()));
            operations.add(Aggregation.sort(Sort.Direction.DESC, "userName"));
            Aggregation aggregation = Aggregation.newAggregation(operations);
            AggregationResults<UserEntity> results = mongoTemplate.aggregate(
                    aggregation, COLLECTION_NAME, UserEntity.class);
            userEntityList = results.getMappedResults();
        }catch (Exception e){
            logger.error("分页查询异常mesg:"+e.getMessage());
        }
        return userEntityList;
    }

}
