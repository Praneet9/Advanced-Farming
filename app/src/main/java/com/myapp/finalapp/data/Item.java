package com.myapp.finalapp.data;

import org.json.JSONObject;

/**
 * Created by Bhumit on 28-01-2017.
 */

public class Item implements JSONPopulator {
    private Condition condition;

    public Condition getCondition() {
        return condition;
    }

    @Override
    public void populate(JSONObject data) {
        condition=new Condition();
        condition.populate(data.optJSONObject("condition"));
    }
}
