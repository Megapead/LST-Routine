package com.gciolac;

/**
 * Higher values will be addressed first
 *
 */
public enum Priority {
    UNDEFINED(0),
    LOW(1),
    MEDIUM(2),
    HIGH(3),
    RESTRICTED(4);

    private int level;

    private Priority(int level){
        this.level = level;
    }

    public int getLevel(){
        return this.level;
    }

}
