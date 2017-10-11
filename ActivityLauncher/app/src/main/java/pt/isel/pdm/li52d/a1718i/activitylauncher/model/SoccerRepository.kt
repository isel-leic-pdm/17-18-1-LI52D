package pt.isel.pdm.li52d.a1718i.activitylauncher.model

/**
 * Created by lfalcao on 11/10/2017.
 */


object SoccerRepository {
    public fun getTeams() : Array<Team> {
        return arrayOf(Team("Benfica", "SLB"), Team("Benfica1", "SLB1"), Team("Benfica2", "SLB2"), Team("Ninjas", "NJ"));
    }
}