package com.eduardo.ef_villalobos.response;

import com.eduardo.ef_villalobos.retrofit.model.Teams;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ShowResponse {

    @SerializedName("Teams")
    public List<Teams> TeamsList;

    public List<Teams> getTeamsList() {
        return TeamsList;
    }

    public void setTeamsList(List<Teams> TeamsList) {
        this.TeamsList = TeamsList;
    }

}
