package org.pocketbooker.entity.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "DebitTypes")
public class DebitTypes {

    @DatabaseField(id = true, unique = true, canBeNull = false)
    private String name;

    public DebitTypes() {
    }

    public DebitTypes(int id, String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
