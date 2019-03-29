package chapter5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple course module abstraction, which defines the Professors teaching the
 * module.
 */
public class Module {

    int moduleId;
    String moduleCode;
    String module;
    List<Integer> professorIds;

    /**
     * Initialize new Module
     *
     * @param moduleId
     * @param moduleCode
     * @param module
     * @param professorIds
     */
    public Module(int moduleId, String moduleCode, String module, List<Integer> professorIds) {
        this.moduleId = moduleId;
        this.moduleCode = moduleCode;
        this.module = module;
        this.professorIds = professorIds;

    }

    /**
     * Get moduleId
     *
     * @return moduleId
     */
    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    /**
     * Get module code
     *
     * @return moduleCode
     */
    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    /**
     * Get module name
     *
     * @return moduleName
     */
    public String getModuleName() {
        return this.module;
    }

    public void setModuleName(String module) {
        this.module = module;
    }

    public List<Integer> getProfessorIds() {
        return professorIds;
    }

    //professorIds.add(getRandomProfessorId()) because of professorIds is a List<Integer>
    /**
     * Get random professor Id
     *
     * @return professorId
     */
    public int getRandomProfessorId() {
        int professorId = professorIds.get((int) (professorIds.size() * Math.random()));
        return professorId;
    }


    public void setProfessorIds(List<Integer> professorIds) {
        this.professorIds = professorIds;
    }

    // initialize the conn variable before execute the query
    // use a try block to handle exceptions properly
}
