package liquibase.actionlogic.core.asany;

import liquibase.Scope;
import liquibase.action.Action;
import liquibase.action.core.CreateTableAction;
import liquibase.action.core.StringClauses;
import liquibase.actionlogic.core.CreateTableLogic;
import liquibase.database.Database;
import liquibase.database.core.asany.SybaseASADatabase;

public class CreateTableLogicSybaseASA extends CreateTableLogic {

    @Override
    protected Class<? extends Database> getRequiredDatabase() {
        return SybaseASADatabase.class;
    }

    @Override
    protected StringClauses generateSql(CreateTableAction action, Scope scope) {
        StringClauses clauses = super.generateSql(action, scope);

        String tablespace = action.tablespace;
        if (tablespace != null) {
            clauses.replace(Clauses.tablespace, "ON "+tablespace);
        }

        return clauses;
    }


}