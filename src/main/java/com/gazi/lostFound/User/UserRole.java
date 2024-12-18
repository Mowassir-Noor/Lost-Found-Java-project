//package com.gazi.lostFound.User;
//
//import java.util.Optional;
//
//public enum UserRole {
//    ADMIN("ADMIN"),
//    USER("USER");
//
//    private final String role;
//
//    UserRole(String role) {
//        this.role = role;
//    }
//
//    @Override
//    public String toString() {
//        return role;
//    }
//
//    public static Optional<UserRole> fromString(String role) {
//        for (UserRole userRole : values()) {
//            if (userRole.role.equalsIgnoreCase(role)) {
//                return Optional.of(userRole);
//            }
//        }
//        return Optional.empty();
//    }
//}

package com.gazi.lostFound.User;

public enum UserRole {
    ROLE_ADMIN,
    ROLE_USER// Administrator role
      // A moderator role, if applicable
}
