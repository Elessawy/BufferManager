package repFactory;

import global.PageId;

import java.util.LinkedList;

import bufmgr.pageDsc;

public class Policy {
	static Policy instance;
	static String policy;
	protected LinkedList<pageDsc> requested;
	protected LinkedList<pageDsc> added;

	protected Policy() {
		// TODO Auto-generated constructor stub
	}

	public static Policy getInstance(String u) {
		if (instance != null) {
			if (!policy.equals(u))// moshkela
				return null;
			return instance;
		} else {
			switch (u) {
			case "FIFO":
				return (instance = new FIFO());
			case "LRU":
				return (instance = new LRU());
			case "MRU":
				return (instance = new MRU());
			case "love/hate":
				return (instance = new LOVE());
			default:
				return (instance = new FIFO());
			}
		}
	}
	public boolean isEmpty() {
		return false;
	}

	public pageDsc getFrame() {
		return null;
	}

	public void update(pageDsc pageDsc) {
	}
	
	public void addToAdded(pageDsc pageDsc) {
		if(!added.contains(pageDsc)){
			added.addLast(pageDsc);
		}else{
			added.remove(pageDsc);
			added.addLast(pageDsc);
		}
	}
	
	public void addToRequested(pageDsc pageDsc) {
		if(!requested.contains(pageDsc)){
			requested.addLast(pageDsc);
		}else{
			requested.remove(pageDsc);
			requested.addLast(pageDsc);
		}
	}
	
	public void removeFromAdded(pageDsc pageDsc) {
		added.remove(pageDsc);
	}
	
	public void removeFromRequested(pageDsc pageDsc) {
		requested.remove(pageDsc);
	}
}
