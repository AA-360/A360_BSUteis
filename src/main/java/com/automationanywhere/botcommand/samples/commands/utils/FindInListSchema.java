package com.automationanywhere.botcommand.samples.commands.utils;

import com.automationanywhere.botcommand.data.model.Schema;
import com.automationanywhere.botcommand.data.model.table.Row;

import java.util.ArrayList;
import java.util.List;
import java.lang.Object;

public class FindInListSchema {

    public List<Schema> schemas;

    public FindInListSchema(List<Schema> objectList) {
        this.schemas = objectList;
    }

    public Boolean exists(String value) {
        for(Schema lsc : this.schemas){
            if(lsc.getName().equals(value)){
                return true;
            }
        }
        return false;
    }
    public int indexSchema(String value) {
        int i = 0;
        for(Schema lsc : this.schemas){
            if(lsc.getName().equals(value)){
                return i;
            }
            i++;
        }
        return -1;
    }
    public List<Integer> indexSchema(List<String> value) {
        List<Integer> lista = new ArrayList();
        for(String v: value){
            int i = 0;
            for(Schema lsc : this.schemas) {
                if (lsc.getName().equals(v)) {
                    lista.add(i);
                }
                i++;
            }
        }
        return lista;
    }
    public List<String> shemaNames() {
        List<String> names = new ArrayList();

        for(Schema lsc : this.schemas){
            names.add(lsc.getName());
        }
        return names;
    }
    public void addSchema(Integer idx,String SchemaName) {
        Schema novo = new Schema(SchemaName);
        this.schemas.add(idx,novo);
    }

}
