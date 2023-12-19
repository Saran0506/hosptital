package com.service;

import java.util.ArrayList;
import java.util.List;

import com.management.AllocationManagement;
import com.management.InPatientManagement;
import com.model.Allocation;
import com.model.InPatient;
import com.util.ApplicationUtil;

public class AllocationService {
		ApplicationUtil auObj=new ApplicationUtil();
		AllocationManagement amObj=new AllocationManagement();
	public List<Allocation> addAllocation(String[] alloc) {
		// TODO Auto-generated method stub
	List<String>extracted=auObj.extractDetails(alloc);
	List<Allocation>aList=buildAllocation(extracted);
	List<Allocation>result=amObj.insertIntoDB(aList);
		return result;
	}
	private List<Allocation> buildAllocation(List<String> extracted) {
		// TODO Auto-generated method stub
		List<Allocation>aList=new ArrayList<Allocation>();
		int count1=0;
		for(String s:extracted) {
			count1++;
			String allocation[]=s.split(":");
			InPatientManagement imObj=new InPatientManagement();
			List<InPatient>ipList=imObj.retriveFromDb(allocation[0]);
			for(InPatient i:ipList) {
				Allocation aObj=new Allocation(generateId(count1),i.getPatientId(),allocation[1], allocation[2], allocation[3], allocation[4], i.getTreatment(),i.getRoomType(),i.getWantFood());
				aList.add(aObj);
			}
			
		}
		return aList;
	}
	int count=0;
	public String generateId(int count1) {
		// TODO Auto-generated method stub
		String id="ALN00";
		String allocatinId=amObj.checkIdExist();
		if(allocatinId=="")
		{
			count++;
			return id+count;
		}
		else if(count1==1) {
			count=Integer.parseInt(allocatinId.substring(5));
			count++;
			return id+count;
	}
		else {
			count++;
			return id+count;
		}
	}	public int checkId(String id) {
		// TODO Auto-generated method stub
		int result=amObj.checkIDFromDB(id);
		return result;
	}
	public List<Allocation> retriveList(String id) {
		// TODO Auto-generated method stub
		List<Allocation>aList=amObj.retriveFromDB(id);
		return aList;
	}
	public int deleteList(String id) {
		// TODO Auto-generated method stub
		int result=amObj.deleteFromDB(id);
		return result;
	}

}
