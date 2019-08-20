package com.entity;

public class Contact {
    private Integer contactId;

    private String contactName;

    private String contactEmail;

    private String contextMessage;

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail == null ? null : contactEmail.trim();
    }

    public String getContextMessage() {
        return contextMessage;
    }

    public void setContextMessage(String contextMessage) {
        this.contextMessage = contextMessage == null ? null : contextMessage.trim();
    }
}