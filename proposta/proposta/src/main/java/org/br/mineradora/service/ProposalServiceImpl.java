package org.br.mineradora.service;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.br.mineradora.dto.ProposalDTO;
import org.br.mineradora.dto.ProposalDetailsDTO;
import org.br.mineradora.entity.ProposalEntity;
import org.br.mineradora.message.KafkaEvent;
import org.br.mineradora.repository.ProposalRepository;

import java.util.Date;

public class ProposalServiceImpl implements ProposalService {

    @Inject
    ProposalRepository proposalRepository;

    @Inject
    KafkaEvent kafkaMessages;

    @Override
    public ProposalDetailsDTO findFullProposal(long id) {

        ProposalEntity proposal = proposalRepository.findById(id);

        return ProposalDetailsDTO.builder()
                .proposalId(proposal.getId())
                .customer(proposal.getCustomer())
                .priceTonne(proposal.getPriceTonne())
                .tonnes(proposal.getTonnes())
                .country(proposal.getCountry())
                .proposalValidityDays(proposal.getProposalValidityDays())
                .build();

    }

    @Override
    @Transactional
    public void createNewProposal(ProposalDetailsDTO proposalDetailsDTO) {

        ProposalDTO proposal = buildAndSaveNewProposal(proposalDetailsDTO);
        kafkaMessages.sendNewKafkaEvent(proposal);

    }

    @Override
    @Transactional
    public void removeProposal(long id) {
        proposalRepository.deleteById(id);
    }

    @Transactional
    private ProposalDTO buildAndSaveNewProposal(ProposalDetailsDTO proposalDetailsDTO) {

        try {

            ProposalEntity proposal = new ProposalEntity();

            proposal.setCreated(new Date());
            proposal.setCustomer(proposalDetailsDTO.getCustomer());
            proposal.setPriceTonne(proposalDetailsDTO.getPriceTonne());
            proposal.setTonnes(proposalDetailsDTO.getTonnes());
            proposal.setCountry(proposalDetailsDTO.getCountry());
            proposal.setProposalValidityDays(proposalDetailsDTO.getProposalValidityDays());

            proposalRepository.persist(proposal);

            return  ProposalDTO.builder()
                    .proposalId(proposalRepository.findByCustomer(proposal.getCustomer()).get().getId())
                    .priceTonner(proposal.getPriceTonne())
                    .customer(proposal.getCustomer())
                    .build();

        } catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException();
        }

    }


}
