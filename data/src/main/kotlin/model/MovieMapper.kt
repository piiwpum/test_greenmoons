package model


fun MovieResponse.mapToDomain(): List<MovieModel> {
    return this.movies?.map {
        MovieModel(
            id = it?.id ?: 0,
            title = it?.titleEn,
            posterUrl = it?.posterUrl,
            moveType = it?.genre,
            releaseDate = it?.releaseDate,
            detail = it?.synopsisEn
        )
    }.orEmpty()
}

fun MovieModel.mapToData(): FavoriteMovieEntity {
    return FavoriteMovieEntity(
        uid = null,
        id = this.id ?: 0,
        title = this.title ?: "",
        posterUrl = this.posterUrl ?: "",
        moveType = this.moveType ?: "",
        releaseDate = this.releaseDate ?: "",
        detail = this.detail ?: ""
    )
}

fun FavoriteMovieEntity.mapToDomain(): MovieModel {
    return MovieModel(
        id = this.id,
        title = this.title,
        posterUrl = this.posterUrl,
        moveType = this.moveType,
        releaseDate = this.releaseDate,
        detail = this.detail
    )
}