package quintino.digital.gercontratapi.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class ContratoImplementacaoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public long recuperarQuantidadeContratoPorMesmoTipo(Long codigo) {
        StringBuilder query = new StringBuilder("SELECT contratoModel.codigo ")
                .append("FROM ContratoModel contratoModel ")
                .append("WHERE contratoModel.tipoContratoModel.codigo = :codigoTipoContrato ");
        TypedQuery<Long> typedQuery = this.entityManager.createQuery(query.toString(), Long.class);
        	typedQuery.setParameter("codigoTipoContrato", codigo);
        return typedQuery.getResultList().size();
    }

}
