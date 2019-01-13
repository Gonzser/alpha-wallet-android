package io.stormbird.wallet.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import io.reactivex.annotations.NonNull;
import io.stormbird.wallet.interact.FetchTokensInteract;
import io.stormbird.wallet.interact.FetchTransactionsInteract;
import io.stormbird.wallet.interact.FindDefaultNetworkInteract;
import io.stormbird.wallet.interact.FindDefaultWalletInteract;
import io.stormbird.wallet.router.MyAddressRouter;
import io.stormbird.wallet.router.TransactionDetailRouter;
import io.stormbird.wallet.service.AssetDefinitionService;
import io.stormbird.wallet.service.TokensService;

public class Erc20DetailViewModelFactory implements ViewModelProvider.Factory {

    private final MyAddressRouter myAddressRouter;
    private final FetchTokensInteract fetchTokensInteract;
    private final FetchTransactionsInteract fetchTransactionsInteract;
    private final FindDefaultNetworkInteract findDefaultNetworkInteract;
    private final FindDefaultWalletInteract findDefaultWalletInteract;
    private final TransactionDetailRouter transactionDetailRouter;
    private final AssetDefinitionService assetDefinitionService;
    private final TokensService tokensService;

    public Erc20DetailViewModelFactory(MyAddressRouter myAddressRouter,
                                       FetchTokensInteract fetchTokensInteract,
                                       FetchTransactionsInteract fetchTransactionsInteract,
                                       FindDefaultNetworkInteract findDefaultNetworkInteract,
                                       FindDefaultWalletInteract findDefaultWalletInteract,
                                       TransactionDetailRouter transactionDetailRouter,
                                       AssetDefinitionService assetDefinitionService,
                                       TokensService tokensService) {
        this.myAddressRouter = myAddressRouter;
        this.fetchTokensInteract = fetchTokensInteract;
        this.fetchTransactionsInteract = fetchTransactionsInteract;
        this.findDefaultNetworkInteract = findDefaultNetworkInteract;
        this.findDefaultWalletInteract = findDefaultWalletInteract;
        this.transactionDetailRouter = transactionDetailRouter;
        this.assetDefinitionService = assetDefinitionService;
        this.tokensService = tokensService;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new Erc20DetailViewModel(myAddressRouter, fetchTokensInteract, fetchTransactionsInteract, findDefaultNetworkInteract, findDefaultWalletInteract, transactionDetailRouter, assetDefinitionService, tokensService);
    }
}
