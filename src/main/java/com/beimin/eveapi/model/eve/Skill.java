package com.beimin.eveapi.model.eve;

import java.util.Collection;
import java.util.HashSet;

public class Skill implements Comparable<Skill> {
    private int typeID;
    private int groupID;
    private String typeName;
    private String description;
    private int rank;
    private boolean published;
    private CharacterAttribute primaryAttribute;
    private CharacterAttribute secondaryAttribute;
    private final Collection<Requirement> requiredSkills = new HashSet<Requirement>();
    private final Collection<Bonus> boneses = new HashSet<Bonus>();

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(final int typeID) {
        this.typeID = typeID;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(final int groupID) {
        this.groupID = groupID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(final String typeName) {
        this.typeName = typeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(final int rank) {
        this.rank = rank;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(final boolean published) {
        this.published = published;
    }

    public CharacterAttribute getPrimaryAttribute() {
        return primaryAttribute;
    }

    public void setPrimaryAttribute(final CharacterAttribute primaryAttribute) {
        this.primaryAttribute = primaryAttribute;
    }

    public CharacterAttribute getSecondaryAttribute() {
        return secondaryAttribute;
    }

    public void setSecondaryAttribute(final CharacterAttribute secondaryAttribute) {
        this.secondaryAttribute = secondaryAttribute;
    }

    public Collection<Requirement> getRequiredSkills() {
        return requiredSkills;
    }

    public Collection<Bonus> getBoneses() {
        return boneses;
    }

    public void add(final Requirement requirement) {
        requiredSkills.add(requirement);
    }

    public void add(final Bonus bonus) {
        boneses.add(bonus);
    }

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder();
        result.append("\t").append(typeName).append(" (").append(rank).append(")\n");
        result.append("\t\tRequires:\n");
        for (final Requirement skillRequirement : requiredSkills) {
            result.append("\t\t\t").append(skillRequirement).append("\n");
        }
        result.append("\t\tBonuses:\n");
        for (final Bonus skillBonus : boneses) {
            result.append("\t\t\t").append(skillBonus).append("\n");
        }

        return result.toString();
    }

    @Override
    public int compareTo(final Skill o) {
        return typeName.compareTo(o.typeName);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + boneses.hashCode();
        result = (prime * result) + ((description == null) ? 0 : description.hashCode());
        result = (prime * result) + groupID;
        result = (prime * result) + ((primaryAttribute == null) ? 0 : primaryAttribute.hashCode());
        result = (prime * result) + (published ? 1231 : 1237);
        result = (prime * result) + rank;
        result = (prime * result) + requiredSkills.hashCode();
        result = (prime * result) + ((secondaryAttribute == null) ? 0 : secondaryAttribute.hashCode());
        result = (prime * result) + typeID;
        result = (prime * result) + ((typeName == null) ? 0 : typeName.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Skill other = (Skill) obj;
        if (!boneses.equals(other.boneses)) {
            return false;
        }
        if (description == null) {
            if (other.description != null) {
                return false;
            }
        } else if (!description.equals(other.description)) {
            return false;
        }
        if (groupID != other.groupID) {
            return false;
        }
        if (primaryAttribute != other.primaryAttribute) {
            return false;
        }
        if (published != other.published) {
            return false;
        }
        if (rank != other.rank) {
            return false;
        }
        if (!requiredSkills.equals(other.requiredSkills)) {
            return false;
        }
        if (secondaryAttribute != other.secondaryAttribute) {
            return false;
        }
        if (typeID != other.typeID) {
            return false;
        }
        if (typeName == null) {
            if (other.typeName != null) {
                return false;
            }
        } else if (!typeName.equals(other.typeName)) {
            return false;
        }
        return true;
    }
}
