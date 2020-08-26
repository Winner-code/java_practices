package com.classmanager.service;

import com.pojo.Classes;

public interface ClassManagerService {
    Classes createClass(Classes classes);
    Classes getClassById(Long id);
}
