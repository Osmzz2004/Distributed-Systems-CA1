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
	@Path("/CommunityFitnessCenterDB/members")
    public List<Member> getAllMembers() {
        MemberDAO dao = new MemberDAO();
        return dao.getAllMembers();
	}
	
}
