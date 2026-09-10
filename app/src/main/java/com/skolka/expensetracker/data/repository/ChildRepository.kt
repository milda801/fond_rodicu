package com.skolka.expensetracker.data.repository

import com.skolka.expensetracker.data.dao.ChildDao
import com.skolka.expensetracker.data.models.Child
import kotlinx.coroutines.flow.Flow

class ChildRepository(private val childDao: ChildDao) {
    
    suspend fun insertChild(child: Child) {
        childDao.insert(child)
    }
    
    suspend fun updateChild(child: Child) {
        childDao.update(child)
    }
    
    suspend fun deleteChild(child: Child) {
        childDao.delete(child)
    }
    
    suspend fun getChildById(id: String): Child? {
        return childDao.getChildById(id)
    }
    
    fun getAllActiveChildren(): Flow<List<Child>> {
        return childDao.getAllActiveChildren()
    }
    
    fun getAllChildren(): Flow<List<Child>> {
        return childDao.getAllChildren()
    }
    
    fun getActiveChildrenCount(): Flow<Int> {
        return childDao.getActiveChildrenCount()
    }
    
    suspend fun deleteChildById(id: String) {
        childDao.deleteChildById(id)
    }
}
