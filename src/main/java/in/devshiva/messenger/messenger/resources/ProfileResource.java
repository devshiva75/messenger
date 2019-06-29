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
import javax.ws.rs.core.MediaType;

import in.devshiva.messenger.messenger.models.Profile;
import in.devshiva.messenger.messenger.services.ProfileService;

@Path("/profiles")
@Produces(MediaType.APPLICATION_XML)
@Consumes(MediaType.APPLICATION_XML)
public class ProfileResource {

	ProfileService ps = new ProfileService();
	
	@GET
	public List<Profile> getAllProfiles(){
		return ps.getAllProfiles();
		
	}
	
	@GET
	@Path("/{profileName}")
	public Profile getProfile(@PathParam("profileName") String name){
		return ps.getProfile(name);	
	}
	
	
	@POST
	public Profile addProfile(Profile profile){
		return ps.addProfile(profile);
	}
	
	@PUT()
	@Path("/{profileName}")
	public Profile updateProfile(Profile profile, @PathParam("profileName") String name){
		profile.setProfileName(name);
		return ps.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profileName}")
	public void updateProfile( @PathParam("profileName") String name){
		ps.removeProfile(name);
	}
	
}
