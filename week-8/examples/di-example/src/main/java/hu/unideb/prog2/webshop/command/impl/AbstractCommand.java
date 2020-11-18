package hu.unideb.prog2.webshop.command.impl;

import hu.unideb.prog2.webshop.command.Command;

public abstract class AbstractCommand implements Command {

	private String userType;
	private String entityType;
	private String action;
	
	public AbstractCommand(String userType, String entityType, String action) {
		super();
		this.userType = userType;
		this.entityType = entityType;
		this.action = action;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((action == null) ? 0 : action.hashCode());
		result = prime * result + ((entityType == null) ? 0 : entityType.hashCode());
		result = prime * result + ((userType == null) ? 0 : userType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof AbstractCommand)) {
			return false;
		}
		AbstractCommand other = (AbstractCommand) obj;
		if (action == null) {
			if (other.action != null) {
				return false;
			}
		} else if (!action.equals(other.action)) {
			return false;
		}
		if (entityType == null) {
			if (other.entityType != null) {
				return false;
			}
		} else if (!entityType.equals(other.entityType)) {
			return false;
		}
		if (userType == null) {
			if (other.userType != null) {
				return false;
			}
		} else if (!userType.equals(other.userType)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "AbstractCommand [userType=" + userType + ", entityType=" + entityType + ", action=" + action + "]";
	}
	
}
