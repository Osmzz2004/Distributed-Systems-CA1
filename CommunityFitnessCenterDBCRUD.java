package CA1;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import CA1.Member;

@Path("/CommunityFitnessCenterDBCRUD")
public class CommunityFitnessCenterDBCRUD {

	@GET
	@Path("/members")
	@Produces("application/json")
    public List<Member> getAllMembers() {
        MemberDAO dao = new MemberDAO();
        return dao.getAllMembers();
	}
	
	@POST
	@Path("/newMember")
	@Consumes("application/json")
	public String addMember(Member member) {
        MemberDAO dao = new MemberDAO();
        dao.persist(member);
        return "Member : " + member.getName() + " added to CommunityFitnessDB";
	}
	
	@PUT
	@Path("/updateMember/")
	@Produces("application/json")
	public Member updateMember(Member member) {
	    MemberDAO dao = new MemberDAO();
	    return dao.merge(member);
	}
	
	@DELETE
	@Path("/deleteMember/{name}")
	@Produces("text/plain")
	public String deleteMember(@PathParam("name")String name) {
        MemberDAO dao = new MemberDAO();
        Member m = dao.getMemberByName(name);
        dao.removeMember(m);
        return "Member : " + m + " deleted";
	}
	
	
    @GET
    @Path("/plans")
    @Produces("application/json")
    public List<MembershipPlan> getAllPlans() {
    	MembershipPlanDAO dao = new MembershipPlanDAO();
        return dao.getAllPlans();
    }

    @POST
    @Path("/newPlan")
    @Consumes("application/json")
    public String addPlan(MembershipPlan plan) {
        MembershipPlanDAO dao = new MembershipPlanDAO();
        dao.persist(plan);
        return "Membership Plan: " + plan.getDescription()
                + " added to CommunityFitnessDB";
    }


    @PUT
    @Path("/updatePlan")
    @Produces("application/json")
    public MembershipPlan updatePlan(MembershipPlan plan) {
    	MembershipPlanDAO dao = new MembershipPlanDAO();
        return dao.merge(plan);
    }

    @DELETE
    @Path("/deletePlan/{id}")
    @Produces("text/plain")
    public String deletePlan(@PathParam("id") int id) {
    	MembershipPlanDAO dao = new MembershipPlanDAO();
        MembershipPlan plan = dao.getPlanById(id);
        dao.removePlan(plan);
        return "Membership Plan: " + plan.getDescription()
                + " deleted";
    }

	
}
