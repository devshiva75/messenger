package in.devshiva.messenger.messenger.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import in.devshiva.messenger.messenger.database.DatabaseClass;
import in.devshiva.messenger.messenger.models.Profile;

public class ProfileService {
	
private Map<String,Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService(){
		
		profiles.put("shiva", new Profile(1L,"shiva","Shiva Kumar","Khandapu"));
		profiles.put("peterj", new Profile(2L,"peterj","Peter","Jaime"));
	}
	
	public List<Profile> getAllProfiles(){
		
		return new ArrayList<Profile>( profiles.values());
	}
	
	public Profile getProfile(String profileName){
		
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile){
		if(profile.getProfileName().isEmpty()){
			return null;
		}
		else{
			profiles.put(profile.getProfileName(), profile);
			return profile;
		}
	}	
	
	public void removeProfile(String profileName){
		profiles.remove(profileName);
	}

}
