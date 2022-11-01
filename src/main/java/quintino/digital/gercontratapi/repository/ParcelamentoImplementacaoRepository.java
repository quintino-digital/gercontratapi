package quintino.digital.gercontratapi.repository;

import org.springframework.stereotype.Repository;
import quintino.digital.gercontratapi.model.ParcelamentoModel;
import quintino.digital.gercontratapi.utility.DateUtility;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ParcelamentoImplementacaoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<ParcelamentoModel> recuperarParcelamentoMesCorrente() {
        StringBuilder query = new StringBuilder("SELECT parcelamentoModel ")
                .append("FROM ParcelamentoModel parcelamentoModel ")
                .append("WHERE parcelamentoModel.dataVencimento BETWEEN :primeiroDiaMesReferencia AND :ultimoDiaMesReferencia ")
                .append("AND parcelamentoModel.dataPagamento IS NULL");
        TypedQuery<ParcelamentoModel> parcelamentoTypedQuery = this.entityManager.createQuery(query.toString(), ParcelamentoModel.class);
                parcelamentoTypedQuery.setParameter("primeiroDiaMesReferencia", DateUtility.gerarData(1));
            parcelamentoTypedQuery.setParameter("ultimoDiaMesReferencia", DateUtility.gerarData(DateUtility.recuperarUltimoDiaMesReferencia()));
        return parcelamentoTypedQuery.getResultList();
    }

}
