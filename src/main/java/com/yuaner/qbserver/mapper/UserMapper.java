package com.yuaner.qbserver.mapper;


import com.yuaner.qbserver.model.dto.UserDTO;
import com.yuaner.qbserver.model.enity.SimpleUser;
import com.yuaner.qbserver.model.enity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
   // @Select("SELECT user_id,user_name,user_password,user_email,create_time FROM yuaner_user WHERE user_id =#{id}")
    SimpleUser getSimpleUserById(Long id);

   //// @Select("SELECT user_id,user_name,user_password,user_email,create_time FROM yuaner_user WHERE user_name =#{userName}")
    SimpleUser getSimpleUserByUserName(String userName);

  //  @Select("SELECT user_id,user_name,user_password,user_email,create_time FROM yuaner_user WHERE user_email =#{userEmail}")
    SimpleUser getSimpleUserByEmail(String userEmail);

   // @Select("SELECT yu.user_id,yu.user_name,yu.user_email,yu.create_time,yui.user_info_id,yui.user_nickname,yui.user_introduction,yui.user_sex,yui.update_time  " +
       //     "FROM yuaner_user yu,yuaner_user_info yui WHERE yu.user_id=yui.user_id AND yu.user_id=#{id}")
    User getUserById(Long id);

   // @Select("SELECT yu.user_id,yu.user_name,yu.user_email,yu.create_time,yui.user_info_id,yui.user_nickname,yui.user_introduction,yui.user_sex,yui.update_time  " +
     //       "FROM yuaner_user yu,yuaner_user_info yui WHERE yu.user_id=yui.user_id AND yu.user_email=#{id}")
    User getUserByEmail(String emailAddress );

    //@Select("SELECT yu.user_id,yu.user_name,yu.user_email,yu.create_time,yui.user_info_id,yui.user_nickname,yui.user_introduction,yui.user_sex,yui.update_time  " +
        ////    "FROM yuaner_user yu,yuaner_user_info yui WHERE yu.user_id=yui.user_id AND yu.user_name=#{id}")
    User getUserByUserName(String userName);

   // @Insert("INSERT  INTO yuaner_user (user_name,user_password,user_email,create_time) VALUES(#{userName},#{userPassword},#{userEmail},#{createTime})")
    //@Options(useGeneratedKeys = true,keyProperty = "userId")
    Boolean addUser(SimpleUser user);

    int updateUserInfo(UserDTO userDTO);
    /**
     * 校验邮箱和用户名是否唯一
     * @param email
     * @param userName
     * @return
     */
    //@Select("SELECT user_id,user_name,user_password,user_email,create_time FROM yuaner_user WHERE user_email =#{email} OR user_name =#{userName}")
    List<SimpleUser> checkUserEmailAndUsernameUnique(String email, String userName);

    /**
     * 查询到全部用户的用户名
     * @return
     */
    //@Select("SELECT  user_name FROM yuaner_user")
    List<String> getAllUsersName();
    List<User> getOnlineUsers(List<String> users);
}
