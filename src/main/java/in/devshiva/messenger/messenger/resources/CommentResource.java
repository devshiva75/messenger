package in.devshiva.messenger.messenger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
public class CommentResource {

	
	@GET
	public String subResourceEx(){
		return "Sub Resources Example!!!";
	}
	
	@GET
	@Path("{commentid}")
	public String getCommentById(@PathParam("messageId") int messageId,@PathParam("commentid") int commentid){
		return "Comment  "+ commentid+" returned based on messageId  " +messageId;
	}
}
