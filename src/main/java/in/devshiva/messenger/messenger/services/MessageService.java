package in.devshiva.messenger.messenger.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import in.devshiva.messenger.messenger.database.DatabaseClass;
import in.devshiva.messenger.messenger.models.Message;

public class MessageService {

	/*List<Message> al = new ArrayList<>();
	
	public List<Message> getAllMessages(){
		
		Message m1 = new Message(1L, "Helloo","Shiva");
		Message m2 = new Message(1L, "Haiii","Shiva K");
		al.add(m1);
		al.add(m2);
		return al;
		}*/
		
	private Map<Long,Message> messages = DatabaseClass.getMessages();
	
	public MessageService(){
		
		messages.put(1L, new Message(1L, "Helloo","Shiva"));
		messages.put(2L, new Message(2L, "Helloo","Khandapu"));
	}
	
	public List<Message> getAllMessages(){
		
		return new ArrayList<Message>( messages.values());
	}
	
	public Message getMessage(Long id){
		
		return messages.get(id);
	}
	
	public Message addMessage(Message message){
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message){
		if(message.getId()<=0){
			return null;
		}
		else{
			messages.put(message.getId(), message);
			return message;
		}
	}
	
	public void removeMessage(Long id){
		 messages.remove(id);
	}
	
	
	public List<Message> getMessagesByYear(int year){
		List<Message> msg = new ArrayList();
		Calendar cal = Calendar.getInstance();
		for(Message message : messages.values()){
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR)==year){
				msg.add(message);
			}
			
		}
		return msg;
	}
	
	public List<Message> getMessagesPaginated(int start,int size){
		ArrayList msg = new ArrayList(messages.values());
		if((start+size)>msg.size())
			return new ArrayList();
		else
			return msg.subList(start, start+size);
		
		
		
	}
}
