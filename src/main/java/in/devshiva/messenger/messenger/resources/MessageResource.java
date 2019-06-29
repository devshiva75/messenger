package in.devshiva.messenger.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import in.devshiva.messenger.messenger.models.Message;
import in.devshiva.messenger.messenger.services.MessageService;

@Path("/messages")
public class MessageResource {

	MessageService mes = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages(@QueryParam("year") int year,@QueryParam("start") int start,@QueryParam("size") int size){
		if(year>0){
			return mes.getMessagesByYear(year);
		}
		if(start>=0 && size>0){
			return mes.getMessagesPaginated(start, size);
		}
		return mes.getAllMessages();
	}
	
	@Path("/{messageId}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Message getMessage(@PathParam("messageId") Long msg){
		return mes.getMessage(msg);
	}
	
	
	/*@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Message addMessage(Message message){
		return mes.addMessage(message);
	}*/
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response addMessage(Message message){
		Message msg = mes.addMessage(message);
		return Response.status(Status.CREATED)
					.entity(msg)
					.build();
	}
	
	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Message updateMessage(Message message,@PathParam("messageId") long id){
		message.setId(id);
		return mes.updateMessage(message);
	}
	
	
	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_XML)
	public void deleteMessage(@PathParam("messageId") long id){
		 mes.removeMessage(id);
	}
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource(){
		return new CommentResource();
	}
}
