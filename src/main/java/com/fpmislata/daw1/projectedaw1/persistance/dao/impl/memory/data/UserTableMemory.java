package com.fpmislata.daw1.projectedaw1.persistance.dao.impl.memory.data;

import com.fpmislata.daw1.projectedaw1.persistance.dao.impl.memory.data.record.UserRecord;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserTableMemory {
    private final List<UserRecord> userRecordList = new ArrayList<>(List.of(
            new UserRecord("admin", "admin@localhost", LocalDate.parse("2021-01-01"), "admin"),
            new UserRecord("user1", "user@localhost", LocalDate.parse("2021-01-01"), "user1"),
            new UserRecord("user2", "user2@localhost", LocalDate.parse("2021-01-01"), "user2")
    ));

    public List<UserRecord> get(){
        return userRecordList;
    }

    public void add(UserRecord userRecord){
        userRecordList.add(userRecord);
    }
}
