package com.fsl.service

import com.fsl.dao.db.UserDao
import org.springframework.stereotype.Service

@Service
class UserDetailsService(val userDao: UserDao) {
    fun getUsers(userName: String?) = userDao.getUsers(userName = userName ?: "")
}