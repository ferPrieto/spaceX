package prieto.fernando.data_repository.repository

import dagger.Reusable
import io.reactivex.Single
import prieto.fernando.data_repository.SpaceXRemoteSource
import prieto.fernando.data_repository.mapper.CompanyInfoRepositoryToDomainModelMapper
import prieto.fernando.data_repository.mapper.LaunchesRepositoryToDomainModelMapper
import prieto.fernando.domain.SpaceXRepository
import prieto.fernando.domain.model.CompanyInfoDomainModel
import prieto.fernando.domain.model.LaunchesDomainModel
import javax.inject.Inject

@Reusable
class SpaceXRepositoryImpl @Inject constructor(
    private val spaceXRemoteSource: SpaceXRemoteSource,
    private val companyInfoDomainMapper: CompanyInfoRepositoryToDomainModelMapper,
    private val launchesDomainMapper: LaunchesRepositoryToDomainModelMapper
) : SpaceXRepository {
    override fun getCompanyInfo(): Single<CompanyInfoDomainModel> =
        spaceXRemoteSource.getCompanyInfo().map(companyInfoDomainMapper::toDomainModel)

    override fun getAllLaunches(): Single<LaunchesDomainModel> =
        spaceXRemoteSource.getAllLaunches().map(launchesDomainMapper::toDomainModel)
}