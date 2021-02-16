package com.prajaram.kotlindemo.graphql

import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsData
import com.netflix.graphql.dgs.InputArgument
import java.util.stream.Collectors


@DgsComponent
class ShowsDataFetcher {

    val shows: List<Show> = listOf(Show("Ozark", 2017),
            Show("bahubali", 2018),
            Show("Friends", 2000)
    )

    @DgsData(parentType = "Query", field = "shows")
    fun shows(@InputArgument("titleFilter") filter: String?): List<Show> {
        return if (filter == null) shows
        else
            shows.stream().filter { it -> it.name.contains(filter) }.collect(Collectors.toList())
    }
}


data class Show(val name: String, val year: Int)